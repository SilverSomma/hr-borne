<template xmlns:v="http://www.w3.org/1999/xhtml">
  <table class="table table-dark table-hover">
    <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
<!--      <th v-for="date in tableDates" scope="col"> {{date.date}} {{date.day}}</th>-->
    </tr>
    </thead>
    <tbody>
    <tr v-for="name in names">
      <th>{{ name.firstName }} {{ name.lastName }}</th>
      <td v-for="date in tableDates"> {{date.date}} {{date.day}}</td>

    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "AbsenceTable",
  data() {
    return {
      names: {},
      absences: {},
      tableDates: [{
        day:"",
        date:"",
        month:"",
        year:"",
      }]
    }
  },
  methods: {
    getAllNames: async function () {
      fetch('http://localhost:8080/names')
          .then(response => response.json())
          .then(data => this.names = data)
          .catch((error) => console.log(error))
    },
    getAllAbsences: async function () {
      fetch('http://localhost:8080/absences')
          .then(response => response.json())
          .then(data => {
            this.absences = data
            this.getTableDates(this.absences)
          })
          .catch((error) => console.log(error))

    },
    parseDate: function (date) {
      let year = date.substring(0, 4)
      let month = parseInt(date.substring(5, 7)) - 1
      let day = date.substring(8, 10)
      return new Date(year, month, day);
    },
    createTableDates: function (minDate,maxDate) {
      const diffTime = Math.abs(maxDate - minDate);
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      for (let i = 0; i < diffDays; i++) {
        let newDate = new Date();
        newDate.setDate(minDate.getDate() + i)
        this.tableDates.push({
          day:newDate.toLocaleDateString(undefined,{weekday:"short"}),
          date:newDate.getDate(),
          month:newDate.toLocaleDateString(undefined,{month:"long"}),
          year:newDate.getFullYear()
        })
      }
      console.log(this.tableDates);
    },
    getTableDates: async function (data) {
      let minDate = Number.MAX_VALUE;
      let maxDate = Number.MIN_VALUE;
      for (let absence of data) {
        let absenceStart = this.parseDate(absence.absenceStart);
        let absenceEnd = this.parseDate(absence.absenceEnd);

        if (absenceStart.valueOf() < minDate.valueOf()) {
          minDate = this.parseDate(absence.absenceStart);
        }
        if (absenceEnd.valueOf() > maxDate.valueOf()) {
          maxDate = this.parseDate(absence.absenceEnd);
        }
      }

      minDate.setDate(minDate.getDate()-4);
      maxDate.setDate(maxDate.getDate()+14);
      this.tableDates = this.createTableDates(minDate,maxDate);
    },
  },
  created() {
    this.getAllNames()
    this.getAllAbsences()
  }
}
</script>

<style scoped>

</style>