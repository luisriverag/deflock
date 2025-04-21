<template>
  <Hero
    imageUrl="/everydoor.webp"
    title="Report using Every Door" 
    description="Add ALPRs to our map using the Every Door app."
  />
  
  <v-container class="mb-16">
    <h1 class="text-center">Adding to the Map</h1>

    <v-alert
      type="warning"
      color="#1297c3"
      class="my-6"
      title="Are You Sure it's an ALPR?"
    >
      <p>
        Please ensure that the device you're reporting <a style="color: white; text-decoration: underline;" href="/what-is-an-alpr#photos">is actually an ALPR</a> and not a commonly mistaken traffic detection camera or other device. Adding incorrect data can lead to confusion and inaccuracies on the map.
      </p>
    </v-alert>

    <v-stepper-vertical color="rgb(18, 151, 195)" v-model="step" flat non-linear class="my-8" edit-icon="mdi-home">
      <template v-slot:default="{ step }: { step: any }">
        <v-stepper-vertical-item
          class="transparent"
          :complete="step > 1"
          title="Create an OpenStreetMap Account"
          value="1"
          editable
        >
          <p>
            <a href="https://www.openstreetmap.org/user/new" target="_blank">Sign up for an OpenStreetMap account</a> in order to submit changes.
          </p>
        </v-stepper-vertical-item>

        <v-stepper-vertical-item
          class="transparent"
          :complete="step > 2"
          title="Download the Every Door App"
          value="2"
          editable
        >
          <p>
            <a target="_blank" href="https://every-door.app/">Download the Every Door app</a> for your device.
          </p>
        </v-stepper-vertical-item>

        <v-stepper-vertical-item
          class="transparent"
          :complete="step > 3"
          title="Add the ALPR"
          value="3"
          editable
        >
          <p>
            Make sure you're using this mode in order to add an ALPR.
          </p>
          <v-img max-width="450" src="/everydoor/1-view-mode.jpg" class="my-8" />

          <p class="mb-8">
            Find the location of the ALPR on the map. Once found, hit the <b>➕</b> button, verify the placement, and hit the <b>✔️</b>.
          </p>

          <p class="mb-8">
            After placing the pin, search for <b>Surveillance Camera</b>:
          </p>

          <v-img max-width="450" src="/everydoor/3-search.png" class="my-8"></v-img>

          <p class="mb-8">
            Set the fields to the following values. Use <b>Direction</b> to set the direction the ALPR faces. If you happen to know the manufacturer of the ALPR, include it as shown in the screenshot below. For help identifying the manufacturer, <a href="/what-is-an-alpr#photos">see our vendor photos</a>.
          </p>

          <v-img max-width="450" src="/everydoor/6-all-fields.png" class="my-8"></v-img>

          <p class="mb-8">
            When finished, save your changes. You can add multiple cameras before uploading them to OSM as a single changeset.
          </p>
        </v-stepper-vertical-item>

        <v-stepper-vertical-item
          class="transparent"
          :complete="step > 5"
          title="Submit Your Changes"
          value="5"
          editable
        >
          <p>
            Once you've added the ALPRs to the map, click the <strong>Upload</strong> button at the bottom-left corner of the app.
          </p>

          <v-img max-width="450" src="/everydoor/7-upload.jpg" class="my-8"></v-img>
          
          <v-alert
              variant="tonal"
              type="info"
              class="my-6"
              title="How Long Will It Take?"
            >
              <p>
                We pull data from OpenStreetMap <i>hourly</i>, so it may take up to an hour for your changes to appear on this site. Rest assured that your changes will be reflected here soon. As we continue to scale, we hope to reduce this delay.
              </p>
          </v-alert>
        </v-stepper-vertical-item>
      </template>
    </v-stepper-vertical>
  </v-container>
</template>

<script setup lang="ts">
import { ref, onMounted, watch } from 'vue';
import { VStepperVerticalItem, VStepperVertical } from 'vuetify/labs/components';
import Hero from '@/components/layout/Hero.vue';

const step = ref(parseInt(localStorage.getItem('currentStepED') || '1'));

onMounted(() => {
  step.value = parseInt(localStorage.getItem('currentStepED') || '1');
});

watch(step, (newStep) => {
  localStorage.setItem('currentStepED', newStep.toString());
});
</script>
