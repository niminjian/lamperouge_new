'use strict'  //"use strict" 的目的是指定代码在严格条件下执行。
const path = require('path')  //引入path模块

function resolve (dir) {
  return path.join(__dirname, dir)  //path.join(__dirname, dir)设置绝对路径
}

module.exports = {
  publicPath: './',
  outputDir: 'admin',
  assetsDir: 'static',
  lintOnSave: true,
  productionSourceMap: false,
  devServer: {
    open: true,
    host: 'localhost',
    port: 8002, //指定了启动端口是8002
    https: false,
    hotOnly: false,
    proxy: {  //开启一个代理服务来请求后端接口
      '/api': {
        target: 'http://localhost:8000',
        changeOrigin: true
      }
    }
  },
  pages: {
    index: {            
      entry: 'src/main.js',   //page的入口
      template: 'public/index.html',  //模板来源
      filename: 'index.html'  //在dist/index.html的输出
    }
  },
  chainWebpack (config) { //配置webpack
    // set svg-sprite-loader
    config.module
      .rule('svg')
      .exclude.add(resolve('src/icons'))
      .end()
    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(resolve('src/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })
      .end()
  }
}
