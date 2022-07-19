<template>
<div>
  {{this.names}}
  <h3>absences</h3>
</div>
</template>

<script>
export default {
  name: "AbsenceView",
  data() {
    return {
      names: {}
    }
  },
  methods:{
    getAllNames:async function() {
      fetch('http://localhost:8080/names',{
        method:'GET',

      })
          .then((response) => {
            // this.names = response.json()
            console.log(response.json())
          })
          .catch((error) => console.log(error))
    },
  },
  mounted() {
    this.getAllNames()
  }
}
</script>

<style scoped>

</style>