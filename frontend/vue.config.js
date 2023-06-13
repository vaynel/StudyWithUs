const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // 빌드 타겟 디렉토리
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080/'
      }
    }
  },

  chainWebpack: config => {
    const svgRule = config.module.rule("svg");
    svgRule.uses.clear();
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");
  }
})
