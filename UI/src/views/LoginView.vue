<template>
  <div>
    <button id="logInButton" type="button" v-on:click="logIn" class="btn btn-primary">Log In</button>
  </div>
</template>

<script>


export default {
  name: "LoginView",
  data: function () {
    return{
      url: 'https://accounts.google.com/o/oauth2/auth?approval_prompt=force&scope=openid&client_id=27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com&redirect_uri=http://localhost:8081/absences&response_type=code&access_type=offline&state=test' }
  },


  methods: {
    logIn: function () {
      fetch( this.url, {
        method: 'GET',
        mode: 'no-cors',
      }
      ).then(response => {
        window.location = 'https://accounts.google.com/o/oauth2/auth?approval_prompt=force&scope=openid&client_id=27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com&redirect_uri=http://localhost:8081/absences&response_type=code&access_type=offline&state=test'
        console.log("AAA")
        console.log(response.data)
      }).catch(error => console.log(error))

      // this.$http.get('https://accounts.google.com/o/oauth2/auth', {
      //   // headers: {
      //   //   'Access-Control-Allow-Origin': '*',
      //   //   'Access-Control-Allow-Methods': '*',
      //   //   'Access-Control-Allow-Headers': '*'
      //   // },
      //   params: {
      //     approval_prompt: 'force',
      //     scope: 'openid',
      //     client_id: '1027130033615-5jhnjfo34a07p8omcqbsf9i3bjl75gqo.apps.googleusercontent.com',
      //     redirect_uri: 'http://localhost:8081/absences',
      //     response_type: 'code',
      //     access_type: 'offline',
      //     state: 'test'
      //   },
      //
      // }).then(response => {
      //   console.log(response.data)
      // }).catch(error => console.log(error))
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