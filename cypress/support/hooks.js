class Hooks {
  randomSizeViewport = () => {
    const sizes = [
      'ipad-2',
      'ipad-2',
      'ipad-mini',
      'macbook-11',
      'macbook-13',
      'macbook-15',
      'iphone-3',
      'iphone-4',
      'iphone-5',
      'iphone-6',
      'iphone-6+',
      'iphone-x',
      'iphone-xr',
      'samsung-note9',
      'samsung-s10'
    ];
    const numberRandom = Math.floor(Math.random() * 14) + 1;
    const viewport = sizes[numberRandom];
    return viewport;
  }
}

export default Hooks;
