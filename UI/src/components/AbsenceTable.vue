<template xmlns:v="http://www.w3.org/1999/xhtml">
  <div>
    <table class="table table-dark table-hover table-bordered">
      <thead>
      <tr>
        <th scope="col"></th>
        <th style="width: 50px;" v-for="date in tableDates" scope="col"><h4>{{ date.date }}</h4> <h5>{{ date.day }}</h5>
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="name in names">
        <th style="width: 150px; height: 50px">{{ name.firstName }} {{ name.lastName }}</th>
        <td style="width: 50px; height: 50px" v-for="date in tableDates">
          <div class="color" v-show="hasAbsences(date, name.id)"></div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

export default {
  name: "AbsenceTable",
  data() {
    return {
      names: {},
      absences: {},
      tableDates: []
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
    createTableDates: function (minDate, maxDate) {
      const diffTime = Math.abs(maxDate - minDate);
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      for (let i = 0; i < diffDays; i++) {
        let newDate = new Date();
        newDate.setDate(minDate.getDate() + i)
        this.tableDates.push({
          day: newDate.toLocaleDateString(undefined, {weekday: "short"}),
          date: newDate.getDate(),
          month: newDate.toLocaleDateString(undefined, {month: "long"}),
          year: newDate.getFullYear()
        })
      }
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

      minDate.setDate(minDate.getDate() - 4);
      maxDate.setDate(maxDate.getDate() + 14);
      this.createTableDates(minDate, maxDate);
    },
    getMonthFromString: function (mon) {
      return new Date(Date.parse(mon + " 1, 2012")).getMonth()
    },
    hasAbsences: function (date, id) {
      for (let absence of this.absences) {
        let startDate = this.parseDate(absence.absenceStart);
        let endDate = this.parseDate(absence.absenceEnd);

        date = new Date(date.year, this.getMonthFromString(date.month), date.date);

        return startDate.valueOf() <= date.valueOf() && endDate.valueOf() >= date.valueOf() && absence.userId === id;
      }
    },
  },
  created() {
    this.getAllNames()
    this.getAllAbsences()
  }
}
</script>

<style scoped>

.color {
  color: aquamarine;
  background-color: aquamarine;
  min-height: 100%;
  min-width: 100%;

}

td {
  margin: 0;
  padding: 0;
}

th {
  margin: 0;
  padding: 0;
}

</style>