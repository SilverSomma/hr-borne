import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios";
import VueAxios from "vue-axios";
import GSignInButton from 'vue-google-signin-button'

Vue.use(GSignInButton)

import GAuth from 'vue-google-oauth2'
const gauthOption = {
    clientId: '27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com',
    scope: 'profile email',
    prompt: 'select_account'
}
Vue.use(GAuth, gauthOption)



Vue.use(VueAxios, axios)
Vue.config.productionTip = false

new Vue({
    router,
    render: function (h) {
        return h(App)
    }
}).$mount('#app')
