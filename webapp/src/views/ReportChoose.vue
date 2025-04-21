<template>
  <Hero
    :opacity="0.53"
    imageUrl="/pole-map.webp"
    title="Add to Our Map" 
    description="We need your help to complete our map!"
  />

  <v-container class="mb-16">
    <v-row justify="center" class="mb-8">
      <v-col cols="12" md="8">
        <h2 class="text-center text-h4 font-weight-bold">Choose Your Reporting Method</h2>
        <p class="text-center text-body-1 mt-4">
          We use OpenStreetMap to source our data. Choose a method below to add to our map.
        </p>
        <p class="sans-serif text-center mt-2">
          <a style="font-size: 0.85em" target="_blank" href="https://deflock.hashnode.dev/why-we-use-openstreetmap">Why do we use OSM?</a>
        </p>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col cols="12" md="5" class="pa-4">
        <v-card
          to="/report/every-door"
          class="mx-auto h-100 d-flex flex-column"
          elevation="4"
          hover
        >
          <v-card-item class="bg-green-lighten-5">
            <v-card-title class="text-h5 font-weight-bold">
              <v-icon icon="mdi-leaf" class="me-2" color="green-darken-1"></v-icon>
              Easy Reporting
            </v-card-title>
            <v-card-subtitle class="pt-2">
              Using the <b>Every Door app</b>
            </v-card-subtitle>
          </v-card-item>

          <v-img class="mx-auto mt-5" src="/everydoor.webp" style="width: 90%; border-radius: 8px;" />

          <v-card-text class="text-body-1">
            <p class="mb-4 sans-serif">Recommended for beginners. The Every Door app provides a simple mobile interface that's easy to use while walking around.</p>
            <p class="sans-serif">Features:</p>
            <ul class="ml-4">
              <li class="my-2">Simple, intuitive interface</li>
              <li class="my-2">Works well on mobile devices</li>
              <li class="mt-2">Minimal learning curve</li>
            </ul>
          </v-card-text>

          <v-card-actions class="pa-4">
            <v-btn
              block
              color="green-darken-1"
              variant="elevated"
              to="/report/every-door"
              size="large"
            >
              Choose Easy
              <v-icon icon="mdi-arrow-right" end></v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>

      <v-col cols="12" md="5" class="pa-4">
        <v-card
          class="mx-auto h-100 d-flex flex-column"
          elevation="4"
          hover
          to="/report/id"
        >
          <v-card-item class="bg-blue-lighten-5">
            <v-card-title class="text-h5 font-weight-bold">
              <v-icon icon="mdi-layers" class="me-2" color="blue-darken-1"></v-icon>
              Advanced Reporting
            </v-card-title>
            <v-card-subtitle class="pt-2">
              Using the <b>iD OSM editor</b>
            </v-card-subtitle>
          </v-card-item>

          <v-img class="mx-auto mt-5" src="/id.webp" style="width: 90%; border-radius: 8px;" />

          <v-card-text class="text-body-1">
            <p class="mb-4 sans-serif">For users who want more control. The iD editor provides a comprehensive interface for detailed reporting.</p>
            <p class="sans-serif">Features:</p>
            <ul class="ml-4">
              <li class="my-2">Full-featured editing capabilities</li>
              <li class="my-2">More detailed attribute settings</li>
              <li class="mt-2">Advanced mapping interface</li>
            </ul>
          </v-card-text>

          <v-card-actions class="pa-4">
            <v-btn
              block
              color="blue-darken-1"
              variant="elevated"
              to="/report/id"
              size="large"
            >
              Choose Advanced
              <v-icon icon="mdi-arrow-right" end></v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import Hero from '@/components/layout/Hero.vue';
</script>

<style scoped>
</style>
