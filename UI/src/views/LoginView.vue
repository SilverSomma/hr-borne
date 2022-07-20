<template>
  <div>
    <button id="logInButton" type="button" v-on:click="test" class="btn btn-primary">Log In</button>
  </div>
</template>

<script>


export default {
  name: "LoginView",
  data: function () {
    return{
      dataUrl: '',
      url: 'https://accounts.google.com/o/oauth2/auth?approval_prompt=force&scope=openid&client_id=27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com&redirect_uri=http://localhost:8081/absences&response_type=code&access_type=offline&state=test' }
  },

  methods: {
    logIn: function () {
      fetch( this.url, {
        method: 'GET',
        mode: 'no-cors',
      }
      ).then(response => {
        window.location = this.url
        console.log("AAA")
        console.log(response.data)
      }).catch(error => console.log(error))

    },


    test: function () {
    fetch('http://localhost:8081/login/oauth').then(response => {
      this.dataUrl = response.json
          console.log("AAAA")
        console.log(this.dataUrl)
    }).catch(error => console.log('ERROR'))
  }
  }
}
</script>

<style scoped>
button {
  width: 10vw;
  height: 5vh;
  margin-left: 45vw;
  margin-top: 45vh;
  font-size: 2em;
}
</style>