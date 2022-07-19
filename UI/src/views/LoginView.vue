<template>
  <div>
    <button v-on:click="logIn()">LOG IN</button>
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
  width: 20vw;
  height: 7vh;
  margin-left: 40vw;
  margin-top: 45vh;
  font-size: 4em;
}
</style>