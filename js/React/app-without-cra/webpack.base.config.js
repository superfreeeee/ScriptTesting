const path = require('path');
const HTMLWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {
    path: path.join(__dirname, '/dist'),
    filename: 'bundle.[hash].js'
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader', 'postcss-loader']
      },{
        test: /\.js[x]?$/,
        use: 'babel-loader',
        exclude: /node-modules/
      },{
        test: /\.less$/,
        use: ['style-loader', 
          { loader: 'css-loader', options: {importLoaders: 1} },
          'less-loader'
        ]
      }
    ]
  },
  plugins: [
    new HTMLWebpackPlugin({
      template: './public/index.html'
    }),
    new CleanWebpackPlugin()
  ]
};
