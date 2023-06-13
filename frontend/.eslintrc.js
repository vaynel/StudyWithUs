module.exports = {
    root:  true,
    parserOptions : {
        parser: '@babel/eslint-parser'
    },

    env: {
        node: true,
        browser: true
    },

    extends: [
        'eslint:recommended',
        'plugin:vue/vue3-recommended'
    ],

    "rules": {
        "vue/multi-word-component-names": ["error", {
            "ignores": ["default", "Login", "Home", "About"]
        }],
        'vue/no-deprecated-slot-attribute': 'off'
    }
}