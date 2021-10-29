import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import Cargo from './Cargo.vue'
import Perfil from './Perfil.vue'
import Usuario from './Usuario.vue'

Vue.use(VueRouter)
Vue.config.productionTip = false

//Como é um projeto pequeno deixarei as rotas neste arquivo mesmo.
const routes = [
  { path: '/usuario', component: Usuario},
  { path: '/perfis', component: Perfil },
  { path: '/', component: Cargo }
  
]

const router = new VueRouter({
  routes // short for `routes: routes`
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
