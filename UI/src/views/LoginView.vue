<template>
  <div>
    <button id="logInButton" type="button" v-on:click="logIn" class="btn btn-primary">Log In</button>
  </div>
</template>

<script>
import router from "@/router/index.js";

export default {
  name: "LoginView",
  methods:{
    logIn: function () {
      router.push('/absences')
    }
  }
}
</script>

<style scoped>
button{
  width: 10vw;
  height: 5vh;
  margin-left: 45vw;
  margin-top: 45vh;
  font-size: 2em;
}
</style>