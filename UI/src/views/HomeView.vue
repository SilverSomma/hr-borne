<template>


  <div>

    <g-signin-button
        :params="googleSignInParams"
        @success="onSignInSuccess"
        @error="onSignInError">
      Sign in with Google
    </g-signin-button>
<!--    <g-signin-button-->
<!--        :params="googleSignInParams"-->
<!--        @success="init"-->
<!--        @error="init">-->
<!--      Sign in with Google-->
<!--    </g-signin-button>-->

    <br>
    <br>
    <a href="#" v-on:click="signOut();">Sign out</a>


  </div>

  <!--  <div class="g-signin2" data-onsuccess="onSignIn"></div>-->


</template>

<script>


export default {
  data() {
    return {
      /**
       * The Auth2 parameters, as seen on
       * https://developers.google.com/identity/sign-in/web/reference#gapiauth2initparams.
       * As the very least, a valid client_id must present.
       * @type {Object}
       */
      googleSignInParams: {
        client_id: '27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com',
      }
    }
  },
  methods: {

    init() {
      gapi.load('auth2', function () {
        // gapi.auth2.getAuthInstance()
        /* Ready. Make a call to gapi.auth2.init or some other API */
      });
    },

    onSignInSuccess(googleUser) {
      // `googleUser` is the GoogleUser object that represents the just-signed-in user.
      // See https://developers.google.com/identity/sign-in/web/reference#users
      const profile = googleUser.getBasicProfile() // etc etc
      console.log("ID: " + profile.getId)
      console.log("ID: " + googleUser.getId)
      console.log(profile)
    },
    onSignInError(error) {
      // `error` contains any error occurred.
      console.log('OH NOES', error)
    },

    signOut() {
      const auth2 = gapi.auth2.getAuthInstance();
      auth2.signOut().then(function () {
        console.log('User signed out.');
      });
    }

  },

  mounted() {
    // this.init();
  }
}


</script>

<style>
.g-signin-button {
  /* This is where you control how the button looks. Be creative! */
  display: inline-block;
  padding: 4px 8px;
  border-radius: 3px;
  background-color: #3c82f7;
  color: #fff;
  box-shadow: 0 3px 0 #0f69ff;
}
</style>
