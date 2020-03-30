const { PNG } = require(`pngjs`);
const fs = require(`fs`);
const path = require(`path`);
const pixelmatch = require(`pixelmatch`);

const reportsDirectory = path.resolve(__dirname, `..`, `report-visual`, `visual-regression`);

function imagePath({ base, name, suffix = `` }) {
  return path.resolve(base, `${name.replace(/ /g, `-`)}${suffix}.png`);
}

function createReport({
  currentImage,
  diff,
  name,
  referenceImage,
}) {
  const reportCurrentImage = imagePath({ base: reportsDirectory, name, suffix: `-CURRENT` });
  const reportReferenceImage = imagePath({ base: reportsDirectory, name, suffix: `-REFERENCE` });
  const reportDiffImage = imagePath({ base: reportsDirectory, name, suffix: `-DIFF` });

  // Create the directory where we want to
  // save regression reports if it doesn't exist.
  if (!fs.existsSync(reportsDirectory)) {
    fs.mkdirSync(reportsDirectory);
  }

  // Copy the screenshots of the current and the
  // reference representation into the reports directory.
  fs.createReadStream(currentImage).pipe(fs.createWriteStream(reportCurrentImage));
  fs.createReadStream(referenceImage).pipe(fs.createWriteStream(reportReferenceImage));
  // Create a diff of the two given images and save
  // the newly created image in the reports directory.
  diff.pack().pipe(fs.createWriteStream(reportDiffImage));

  return reportDiffImage;
}

function compare({ currentImage, name, referenceImage }) {
  return new Promise((resolve, reject) => {
    let img1;
    let img2;
    let imagesParsed = false;

    function matchImages() {
      // Make sure both, img1 and img2 were parsed.
      if (!imagesParsed) {
        imagesParsed = true;
        return;
      }

      const diff = new PNG({ width: img1.width, height: img1.height });
      // pixelmatch returns 0 if the images do exactly match,
      // it returns a value > 0 if they don't match.
      const imageMismatch = pixelmatch(
        img1.data,
        img2.data,
        diff.data,
        img1.width,
        img1.height,
        {
          threshold: 0.1,
        },
      );

      if (imageMismatch) {
        const reportDiffImage = createReport({
          currentImage,
          diff,
          name,
          referenceImage,
        });

        // If the images do not match exactly, the promise
        // is rejected which we'll later use to make our test fail.
        reject(new Error(`${name} does not look the same as before. See diff: ${reportDiffImage}`));
      }

      resolve(true);
    }

    // The reference image and the current image are asynchronously
    // read and parsed, not until both of them were parsed, they are
    // compared and the promise returned by the `compare()` function
    // is either resolved or rejected.
    img1 = fs.createReadStream(referenceImage).pipe(new PNG()).on(`parsed`, matchImages);
    img2 = fs.createReadStream(currentImage).pipe(new PNG()).on(`parsed`, matchImages);
  });
}

module.exports = {
  compare,
  imagePath,
};