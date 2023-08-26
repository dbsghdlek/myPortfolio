import { createApp } from 'vue'
import App from './App.vue'
import { store } from './store/myStore'
import BootstrapVue3 from 'bootstrap-vue-3'
import router from './router/MyRouter'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import AudioPlayer from '@liripeng/vue-audio-player'

const app = createApp(App)

app.use(AudioPlayer)
app.use(store)
app.use(router)
app.use(BootstrapVue3)
app.mount('#app')