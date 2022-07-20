<template>

  <div>
    <nav>
    </nav>
    <div class="d-grid gap-2 d-md-block">
      <button class="btn-primary" type="button" v-on:click="showNewAbsenceModal">New leave</button>
    </div>

    <div id="absenceRegistrationWindow" v-if="">
      <h2>Choose your dates:</h2>
      <!--          <div>-->

      <div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Vacation
          <label class="form-check-label" for="radio1"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Unpaid Vacation
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Child Vacation
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Child Leave
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Care Leave
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Paternity Leave
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Sickness
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Home Office
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Study Leave
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Training or CONF
          <label class="form-check-label" for="radio2"></label>
        </div>
        <div class="form-check">
          <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Business Trip
          <label class="form-check-label" for="radio2"></label>
        </div>
      </div>

    </div>
  </div>


  <!--  <div id="absenceRegistrationWindow" v-if="">-->
  <!--    <h2>Choose your dates:</h2>-->
  <!--    <div>-->


  <!--    </div>-->

</template>

<script>
export default {
  // name: "AbsenceView",
  components: {},
  methods: {
    showNewAbsenceModal: function () {
      alert('Hello')
      // document.querySelector(".newAbsenceModal").classList.toggle("hidden");
    }
  },
  data() {
    return {
      value1: true,
      value2: false
    }
  }
}
</script>

<style>

.btn-primary {
  background-color: #EB5E00;
  font-family:Open Sans;
}


.form-check {
  color: #EB5E00;
  font-family:Open Sans

}
.invisible {
  visibility: hidden;
}

</style>