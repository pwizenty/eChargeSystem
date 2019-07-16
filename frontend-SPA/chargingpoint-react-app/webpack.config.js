module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader"
        }
      },
	  {
        test: /\.css$/,
        use: ['react-web-component-style-loader', 'css-loader']
      }
    ]
  }
};