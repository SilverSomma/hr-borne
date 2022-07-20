<template xmlns:v="http://www.w3.org/1999/xhtml">
  <div>
    <table class="table table-light table-hover table-bordered">
      <thead>
      <tr>
        <th scope="col"></th>
        <th v-for="date in tableDates" :class="{todayFirstRow: isToday(date)}" scope="col"><h4 class="dateNumber">
          {{ date.date }}</h4> <h5 class="day" :class="{dayOpacity: isToday(date)}">{{ date.day }}</h5>
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="name in names">
        <th class="nameColumn" scope="row">{{ name.firstName }} {{ name.lastName }}</th>
        <td v-for="date in tableDates" :class="{todayMiddleRow: isToday(date), todayLastRow: isTodayLast(date,name)}">
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
  created() {
    this.getAllNames()
    this.getAllAbsences()
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
          day: newDate.toLocaleDateString(undefined, {weekday: "short"}).substring(0, 2).toUpperCase(),
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
      date = new Date(date.year, this.getMonthFromString(date.month), date.date);

      for (let absence of this.absences) {
        let startDate = this.parseDate(absence.absenceStart);
        let endDate = this.parseDate(absence.absenceEnd);

        if (startDate.valueOf() <= date.valueOf() && endDate.valueOf() >= date.valueOf() && absence.userId === id) {
          return true;
        }
      }
      return false;
    },
    isToday: function (date) {
      date = new Date(date.year, this.getMonthFromString(date.month), date.date);
      let today = new Date();
      let todayDate = new Date(today.getFullYear(), today.getMonth(), today.getDate());

      if (date.valueOf() === todayDate.valueOf()) {
        console.log('today')
        return true;
      }
      return false;
    },
    isTodayLast: function (date, name) {
      date = new Date(date.year, this.getMonthFromString(date.month), date.date);
      let today = new Date();
      let todayDate = new Date(today.getFullYear(), today.getMonth(), today.getDate());

      if (this.names.at(-1) === name && date.valueOf() === todayDate.valueOf()) {
        console.log('todaylast')
        console.log(name)
        return true;
      }
      return false;
    }
  }
}
</script>

<style scoped>

.color {
  background-color: #f1eea1;
  min-height: 100%;
  min-width: 100%;
}

td {
  margin: 0;
  padding: 0;
  min-width: 50px;
  height: 50px;
}

th {
  margin: 0;
  padding: 0;
}

.todayFirstRow {
  border: 2px solid #FD9B5B;
  border-bottom: none;
  color: #FD9B5B;
  opacity: 1;
}

.todayMiddleRow {
  border-left: 2px solid #FD9B5B;
  border-right: 2px solid #FD9B5B;
}

.todayLastRow {
  border: 2px solid #FD9B5B;
  border-top: none;
}

.dateNumber {
  text-align: center;
  font-size: 1.3em;
}

.day {
  text-align: center;
  font-size: 0.8em;
  opacity: 0.2;
}

.nameColumn {
  min-width: 150px;
  text-align: center;
  line-height: 50px;
}

.dayOpacity {
  opacity: 1;
}

</style>