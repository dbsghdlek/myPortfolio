const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  devServer : {
    port : 8080,
    proxy :{
      '^/menu':{
        target : 'http://localhost:8080',
        changeOrigin : true
      },
      '^/music':{
        target : 'http://localhost:8080',
        changeOrigin : true
      }
    }
  }
}