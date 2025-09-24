<template>
<Hero
  imageUrl="/city-council.jpg"
  title="City Council"
  description="Block ALPRs in your community using the proven technique of petitioning your city or town's council."
/>

<v-container class="mb-16">
  <!-- Introduction Section -->
  <v-row class="mb-12">
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <div class="text-center mb-8">
        <v-icon size="64" color="var(--df-blue)" class="mb-4">mdi-account-voice</v-icon>
        <h2 class="text-h4 mb-4 font-weight-bold">Your Voice Matters at City Council</h2>
        <p class="text-h6 text-medium-emphasis serif">
          Public participation is the cornerstone of democracy. Here's how to effectively advocate 
          against ALPR surveillance systems at your local city council meetings.
        </p>
      </div>
    </v-col>
  </v-row>

  <!-- Quick Start Guide -->
  <v-row class="mb-12">
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <v-card class="pa-6" elevation="3" rounded="lg">
        <div class="text-center mb-6">
          <v-icon size="48" color="success" class="mb-3">mdi-rocket-launch</v-icon>
          <h3 class="text-h5 font-weight-bold">Quick Start: 3 Steps to Success</h3>
        </div>
        
        <v-row>
          <v-col cols="12" md="4" class="text-center">
            <v-avatar size="60" color="primary" class="mb-3">
              <span class="text-h4 white--text">1</span>
            </v-avatar>
            <h4 class="text-h6 mb-2">Research & Prepare</h4>
            <p class="text-body-2">Know the meeting schedule, agenda, and speaking rules</p>
          </v-col>
          <v-col cols="12" md="4" class="text-center">
            <v-avatar size="60" color="primary" class="mb-3">
              <span class="text-h4 white--text">2</span>
            </v-avatar>
            <h4 class="text-h6 mb-2">Craft Your Message</h4>
            <p class="text-body-2">Use our talking points and keep it within the time limit (usually around 3 minutes)</p>
          </v-col>
          <v-col cols="12" md="4" class="text-center">
            <v-avatar size="60" color="primary" class="mb-3">
              <span class="text-h4 white--text">3</span>
            </v-avatar>
            <h4 class="text-h6 mb-2">Speak & Follow Up</h4>
            <p class="text-body-2">Deliver your message and engage with council members after the meeting</p>
          </v-col>
        </v-row>
      </v-card>
    </v-col>
  </v-row>

  <!-- Success Stories -->
  <v-row class="mb-12">
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <v-card class="pa-6" elevation="3" rounded="lg" color="success" variant="tonal">
        <div class="d-flex align-center mb-6">
          <v-icon size="40" color="success" class="mr-3">mdi-trophy</v-icon>
          <h3 class="text-h5 font-weight-bold">Timeline of Recent Victories</h3>
        </div>
        
        <div class="timeline-container">
          
          <!-- Timeline Items -->
          <div v-for="city in citiesRejectingFlock" class="timeline-item">
            <div class="timeline-marker">
              <v-avatar size="48" color="success">
                <v-icon color="white">mdi-check-bold</v-icon>
              </v-avatar>
            </div>
            <div class="timeline-content">
              <div class="timeline-card">
                <div class="d-flex align-center justify-space-between mb-2">
                  <h4 class="text-h6 font-weight-bold">{{ city.cityState }}</h4>
                  <v-chip size="small" color="grey" variant="outlined">{{ city.monthYear }}</v-chip>
                </div>
                <p v-html="city.descriptionHtml" class="text-body-2 mb-2" />
                <v-chip size="small" color="success" variant="outlined">{{ city.outcome }}</v-chip>
              </div>
            </div>
          </div>

        </div>
      </v-card>
    </v-col>
  </v-row>

  <!-- CTA instead of talking points -->

  <!-- First-Time Speaker Guide -->
  <v-row class="mb-12">
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <v-card class="pa-6" elevation="3" rounded="lg" color="info" variant="tonal">
        <div class="d-flex align-center mb-6">
          <v-icon size="40" color="info" class="mr-3">mdi-microphone</v-icon>
          <h3 class="text-h5 font-weight-bold">First-Time Speaker's Guide</h3>
        </div>

        <v-row>
          <v-col cols="12" md="6">
            <h4 class="text-h6 mb-3 d-flex align-center text">
              <v-icon color="info" class="mr-2">mdi-clock</v-icon>
              Before the Meeting
            </h4>
            <v-list density="compact">
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Check meeting schedule and agenda online.</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Sign up for public comment (often required).</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Prepare 2-3 minute statement (practice timing).</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Bring a copy of your statement.</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-col>
          <v-col cols="12" md="6">
            <h4 class="text-h6 mb-3 d-flex align-center">
              <v-icon color="success" class="mr-2">mdi-presentation</v-icon>
              During the Meeting
            </h4>
            <v-list density="compact">
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Arrive on time or early.</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>State your name and connection to the city.</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Speak clearly and maintain eye contact.</v-list-item-title>
              </v-list-item>
              <v-list-item prepend-icon="mdi-check">
                <v-list-item-title>Stay respectful, and thank council for their time.</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-col>
        </v-row>

        <v-divider class="my-4"></v-divider>

        <v-alert type="info" variant="tonal" class="mb-4">
          <strong>Pro Tip:</strong> Focus on how ALPRs affect YOUR community specifically. Personal stories and local examples are more compelling than abstract arguments.
        </v-alert>
      </v-card>
    </v-col>
  </v-row>

  <!-- Community Support Section -->
  <v-row class="mb-12">
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <v-card class="pa-6" elevation="3" rounded="lg" color="primary" variant="tonal">
        <div class="text-center">
          <v-icon size="64" color="primary" class="mb-4">mdi-comment-question</v-icon>
          <h3 class="text-h4 font-weight-bold mb-4">Need Help or Have Questions?</h3>
          <p class="text-h6 mb-6 serif">
            Join our supportive community of activists and experienced speakers who are ready to help you succeed.
          </p>
          
          <v-btn
            href="https://discord.gg/aV7v4R3sKT"
            target="_blank"
            size="large"
            color="primary"
            class="mr-4 mb-4"
            prepend-icon="mdi-discord"
          >
            Join #campaigning Channel
          </v-btn>
        </div>
      </v-card>
    </v-col>
  </v-row>

  <!-- Additional Resources -->
  <v-row>
    <v-col cols="12" md="10" lg="8" class="mx-auto">
      <v-card class="pa-6" elevation="3" rounded="lg">
        <h3 class="text-h5 font-weight-bold mb-4 d-flex align-center">
          <v-icon color="primary" class="mr-3">mdi-video</v-icon>
          Example Videos
        </h3>
        <v-row>
          <v-col v-for="video in videos" :key="video.url" cols="12" md="6" class="mb-4">
            <v-card 
              class="video-card pa-6 d-flex flex-column align-center justify-center text-center"
              elevation="3" 
              rounded="lg"
              hover
              @click="openVideo(video.url)"
            >
              <div class="video-play-container mb-4">
                <v-avatar size="80" color="red" class="video-play-button">
                  <v-icon size="40" color="white">mdi-play</v-icon>
                </v-avatar>
              </div>
              
              <h4 class="text-h5 font-weight-bold mb-2">{{ video.location }}</h4>
              <p class="text-body-2 text-medium-emphasis mb-4">{{ video.description }}</p>
              
              <v-btn
                color="red"
                variant="outlined"
                size="large"
                prepend-icon="mdi-youtube"
                class="mt-auto"
                @click.stop="openVideo(video.url)"
              >
                Watch on YouTube
              </v-btn>
            </v-card>
          </v-col>
        </v-row>
      </v-card>
    </v-col>
  </v-row>
</v-container>

<Footer/>
</template>

<script setup lang="ts">
import Hero from '@/components/layout/Hero.vue';
import Footer from '@/components/layout/Footer.vue';
import { computed } from 'vue';
import { useTheme } from 'vuetify';

const theme = useTheme();
const isDark = computed(() => theme.name.value === 'dark');

interface CityRejection {
  cityState: string;
  monthYear: string;
  descriptionHtml: string;
  outcome: string;
}

const citiesRejectingFlock: CityRejection[] = [
  {
    cityState: "Denver, CO",
    monthYear: "May 2025",
    descriptionHtml: 'City council <a href="https://denverite.com/2025/05/05/denver-rejects-flock-camera-license-plate-readers/" target="_blank">voted unanimously</a> to reject the $666,000 contract extension with Flock Safety after public pushback and concerns over privacy, civil liberties, and sharing data with federal agencies.',
    outcome: 'Contract Rejected'
  },
  {
    cityState: "Austin, TX",
    monthYear: "June 2025",
    descriptionHtml: 'City council <a target="_blank" href="https://www.eff.org/deeplinks/2025/06/victory-austin-organizers-cancel-citys-flock-alpr-contract">voted to block the renewal</a> of Austin\'s contract with Flock Safety after controversial uses for the system, violations of department policy, and contract language that went against council mandates on data retention.',
    outcome: 'Contract Rejected'
  },
  {
    cityState: "Oak Park, IL",
    monthYear: "August 2025",
    descriptionHtml: 'City council voted to cancel its contract with Flock Safety following a state investigation of the system\'s data sharing practices, <a href="https://www.oakpark.com/2025/08/07/oak-park-terminates-flock-license-plate-reader-contract/" target="_blank">which enabled violations of state law</a>.',
    outcome: 'Contract Canceled'
  },
  {
    cityState: "Evanston, IL",
    monthYear: "August 2025",
    descriptionHtml: 'The City of Evanston ended its contract with Flock Safety and requested the deactivation of the cameras following an audit by the Secretary of State showing the company was <a target="_blank" href="https://evanstonroundtable.com/2025/08/26/evanston-shuts-down-license-plate-cameras-terminates-contract-with-flock-safety/">violating state law</a> by sharing Illinois data with federal agencies. Flock then <a target="_blank" href="https://evanstonroundtable.com/2025/09/24/flock-safety-reinstalls-evanston-cameras/">reinstalled the cameras against the city\'s wishes</a>, prompting a cease-and-desist by the city.',
    outcome: 'Contract Canceled',
  },
  {
    cityState: "Louisville, CO",
    monthYear: "August 2025",
    descriptionHtml: 'The City of Louisville deactivated its cameras after a community member found that the system <a target="_blank" href="https://www.cbsnews.com/colorado/news/license-plate-reading-cameras-colorado-regulation-misuse/">was severely misrepresented</a> in both its data sharing practices and its capabilities.',
    outcome: 'Cameras Deactivated'
  },
  {
    cityState: "Sedona, AZ",
    monthYear: "September 2025",
    descriptionHtml: 'City council voted unanimously to end their contract with Flock Safety after council members claimed they were <a href="https://www.knau.org/knau-and-arizona-news/2025-09-11/sedona-council-permanently-ends-license-plate-camera-program" target="_blank">misled and lied to</a> about the system\'s data sharing features.',
    outcome: 'Contract Canceled'
  }
].sort((a, b) => {
  const [aMonth, aYear] = a.monthYear.split(/\s/);
  const [bMonth, bYear] = b.monthYear.split(/\s/);
  const aDate = new Date(`${aMonth} 1, ${aYear}`);
  const bDate = new Date(`${bMonth} 1, ${bYear}`);
  return bDate.getTime() - aDate.getTime();
}); //reverse chron order

const videos = [
  {
    location: "Flagstaff, AZ",
    url: "https://youtu.be/6L6UlDJFYWk?si=gt_mU5rvayn1KCKi",
    description: "Community members address privacy concerns, constitutional rights, and local impacts at city council meeting."
  },
  {
    location: "Eugene, OR",
    url: "https://youtu.be/FpXyS0dqUSM?si=0F8ZlijJYY_j7UjL&t=96",
    description: "Residents discuss fiscal responsibility and effectiveness of ALPR surveillance systems."
  },
  {
    location: "Denver, CO",
    url: "https://youtu.be/YjaH_1Ia6NA?si=470JU6kqwk-vdXl0",
    description: "Council member discusses the impact of mass surveillance technology on civil liberties."
  },
];

const openVideo = (url: string) => {
  window.open(url, '_blank');
};

</script>

<style scoped>
.talking-points {
  list-style: none;
  padding: 0;
}

.talking-points li {
  padding: 8px 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.talking-points li:last-child {
  border-bottom: none;
}

.talking-points li::before {
  content: "•";
  color: var(--df-blue);
  font-weight: bold;
  display: inline-block;
  width: 1em;
  margin-left: 0;
}

.v-card {
  transition: box-shadow 0.2s ease-in-out;
}

.v-card:hover {
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15) !important;
}

.v-expansion-panel-title {
  font-weight: 500;
}

.v-avatar {
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.success-story-card {
  transition: all 0.3s ease;
  border-left: 4px solid transparent;
}

.success-story-card:hover {
  border-left-color: var(--df-blue);
}

.v-list-item-title {
  white-space: normal !important;
  overflow: visible !important;
  text-overflow: unset !important;
  line-height: 1.4 !important;
  word-break: normal !important;
  hyphens: none !important;
  overflow-wrap: break-word !important;
}

.v-list-item {
  min-height: auto !important;
  padding-top: 8px !important;
  padding-bottom: 8px !important;
}

/* Timeline Styles */
.timeline-container {
  position: relative;
  padding-left: 24px;
}

.timeline-container::before {
  content: '';
  position: absolute;
  left: 24px;
  top: 24px;
  bottom: 24px;
  width: 2px;
  background: linear-gradient(to bottom, 
    rgba(76, 175, 80, 0.8) 0%, 
    rgba(76, 175, 80, 0.6) 50%, 
    rgba(76, 175, 80, 0.4) 100%);
}

.timeline-item {
  position: relative;
  padding-bottom: 32px;
}

.timeline-item-last {
  padding-bottom: 0;
}

.timeline-marker {
  position: absolute;
  left: -24px;
  top: 0;
  z-index: 2;
}

.timeline-content {
  margin-left: 40px;
}

.timeline-card {
  background: rgba(255, 255, 255, 0.9);
  border: 1px solid rgba(76, 175, 80, 0.2);
  border-radius: 12px;
  padding: 16px;
  box-shadow: 0 2px 8px rgba(76, 175, 80, 0.1);
  transition: all 0.2s ease;
}

.timeline-card:hover {
  box-shadow: 0 4px 16px rgba(76, 175, 80, 0.15);
  border-color: rgba(76, 175, 80, 0.3);
}

/* Dark theme support */
.v-theme--dark .timeline-card {
  background: rgba(0, 0, 0, 0.3);
  border-color: rgba(76, 175, 80, 0.3);
}

.v-theme--dark .timeline-card:hover {
  border-color: rgba(76, 175, 80, 0.4);
}

@media (max-width: 768px) {
  .timeline-container {
    padding-left: 16px;
  }
  
  .timeline-container::before {
    left: 16px;
  }
  
  .timeline-marker {
    left: -16px;
  }
  
  .timeline-content {
    margin-left: 32px;
  }
}

/* Video Card Styles */
.video-card {
  min-height: 280px;
  cursor: pointer;
  background: linear-gradient(135deg, #f5f5f5 0%, #ffffff 100%);
  border: 2px solid transparent;
  transition: all 0.3s ease;
}

.video-card:hover {
  border-color: #f44336;
  transform: translateY(-4px);
  box-shadow: 0 12px 30px rgba(244, 67, 54, 0.2) !important;
}

.video-play-container {
  position: relative;
}

.video-play-button {
  transition: all 0.3s ease;
  box-shadow: 0 4px 20px rgba(244, 67, 54, 0.3);
}

.video-card:hover .video-play-button {
  transform: scale(1.1);
  box-shadow: 0 6px 25px rgba(244, 67, 54, 0.4);
}

.video-play-container::before {
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 100px;
  height: 100px;
  border: 2px solid rgba(244, 67, 54, 0.2);
  border-radius: 50%;
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0% {
    transform: translate(-50%, -50%) scale(0.8);
    opacity: 1;
  }
  100% {
    transform: translate(-50%, -50%) scale(1.2);
    opacity: 0;
  }
}

/* Dark theme support for video cards */
.v-theme--dark .video-card {
  background: linear-gradient(135deg, #1e1e1e 0%, #2d2d2d 100%);
}

.v-theme--dark .video-card:hover {
  box-shadow: 0 12px 30px rgba(244, 67, 54, 0.3) !important;
}
</style>