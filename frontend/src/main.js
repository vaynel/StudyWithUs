import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import { router } from '@/router'
import store from '@/store/user/signup'
import axios from 'axios'


const pinia = createPinia()
const app = createApp(App)

// axios 설정
axios.defaults.headers.get['Content-Type'] = 'application/json';
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.headers.put['Content-Type'] = 'application/json';

app.use(router)
app.config.globalProperties.axios = axios
app.use(store)
    .use(pinia)
    .mount('#app')

