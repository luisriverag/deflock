<template>
  <v-container class="my-16">
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
          class="mx-auto h-100 d-flex flex-column"
          elevation="4"
          hover
          to="/app"
        > 
          <v-card-item class="bg-green-darken-3">
            <v-card-title class="text-h5 font-weight-bold text-white">
              DeFlock App
            </v-card-title>
            <v-card-subtitle class="pt-2">
              for iOS and Android
            </v-card-subtitle>
          </v-card-item>
        
          <v-img cover :aspect-ratio="1.5" class="mx-auto mt-5" src="/app-screenshots/df-app.webp" style="width: 90%; border-radius: 8px;" />
        
          <v-card-text class="text-body-1">
            <p class="mb-4 sans-serif">The <b>DeFlock App</b> provides a simple mobile interface that's easy to use while walking around.</p>
          </v-card-text>
        
          <v-card-actions class="pa-4">
            <v-btn
              block
              color="green-darken-2"
              variant="elevated"
              size="large"
            >
              Download App
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
          <v-card-item class="bg-blue-darken-3">
            <v-card-title class="text-h5 font-weight-bold text-white">
              Legacy Editor
            </v-card-title>
            <v-card-subtitle class="pt-2">
              Using the <b>OSM Web Editor</b>
            </v-card-subtitle>
          </v-card-item>

          <v-img cover :aspect-ratio="1.5" class="mx-auto mt-5" src="/id.webp" style="width: 90%; border-radius: 8px;" />

          <v-card-text class="text-body-1">
            <p class="mb-4 sans-serif">The <b>OSM Web Editor</b> provides a more advanced interface for detailed reporting in your web browser.</p>
          </v-card-text>

          <v-card-actions class="pa-4">
            <v-btn
              block
              color="blue-darken-1"
              variant="elevated"
              to="/report/id"
              size="large"
            >
              How to Edit
              <v-icon icon="mdi-arrow-right" end></v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
