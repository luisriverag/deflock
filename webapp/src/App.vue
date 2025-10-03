<script setup lang="ts">
import { RouterView, useRouter } from 'vue-router'
import { computed, ref, watch, onMounted } from 'vue'
import { useTheme } from 'vuetify';
import DiscordWarningDialog from '@/components/DiscordWarningDialog.vue';
import { useDiscordIntercept } from '@/composables/useDiscordIntercept';

const theme = useTheme();
const router = useRouter();
const snackbar = ref({ show: false, text: '' });
const isDark = computed(() => theme.name.value === 'dark');
const isFullscreen = computed(() => router.currentRoute.value?.query.fullscreen === 'true');
const { showDialog, discordUrl, interceptDiscordLinks } = useDiscordIntercept();

function toggleTheme() {
  const newTheme = theme.global.name.value === 'dark' ? 'light' : 'dark';
  theme.global.name.value = newTheme;
  localStorage.setItem('theme', newTheme);

  if (newTheme === 'dark' && router.currentRoute.value.path === '/map') {
    snackbar.value = {
      show: true,
      text: "Dark maps aren't available yet :("
    };
  }
}

function handleDiscordProceed(url: string) {
  window.open(url, '_blank');
}

onMounted(() => {
  const savedTheme = localStorage.getItem('theme');
  if (savedTheme) {
    theme.global.name.value = savedTheme;
  } else {
    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    theme.global.name.value = prefersDark ? 'dark' : 'light';
    localStorage.setItem('theme', theme.global.name.value);
  }
  interceptDiscordLinks();
});

const items = [
  { title: 'Home', icon: 'mdi-home', to: '/' },
  { title: 'Map', icon: 'mdi-map', to: '/map' },
  { title: 'Learn', icon: 'mdi-school', to: '/what-is-an-alpr' },
]

const contributeItems = [
  { title: 'Submit Cameras', icon: 'mdi-map-marker-plus', to: '/report' },
  { title: 'Public Records', icon: 'mdi-file-document', to: '/foia' },
  { title: 'City Council', icon: 'mdi-account-voice', to: '/council' },
]

const metaItems = [
  { title: 'Discord', customIcon: '/icon-discord.svg', customIconDark: '/icon-discord-white.svg', href: 'https://discord.gg/aV7v4R3sKT'},
  { title: 'Contact', icon: 'mdi-email-outline', to: '/contact' },
  { title: 'GitHub', icon: 'mdi-github', href: 'https://github.com/frillweeman/deflock'},
  { title: 'Donate', icon: 'mdi-heart', to: '/donate'},
];
const drawer = ref(false)

watch(() => theme.global.name.value, (newTheme) => {
  const root = document.documentElement;
  if (newTheme === 'dark') {
    root.style.setProperty('--df-background-color', 'rgb(33, 33, 33)');
    root.style.setProperty('--df-text-color', '#ccc');
  } else {
    root.style.setProperty('--df-background-color', 'white');
    root.style.setProperty('--df-text-color', 'black');
  }
});
</script>

<template>
  <v-app>
    <template v-if="!isFullscreen">
      <v-app-bar
        flat
        prominent
      >
        <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

        <v-toolbar-title style="flex: unset;">
          <div style="display: flex; align-items: center; cursor: pointer;" @click="router.push('/')">
            <v-img height="36" width="36" src="/favicons/apple-icon-144x144.png" />
            <v-img style="margin-left: 8px;" height="36" width="130" src="/deflock-logo.svg" />
          </div>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn icon>
          <v-icon @click="toggleTheme">mdi-theme-light-dark</v-icon>
        </v-btn>
      </v-app-bar>

      <v-navigation-drawer
        v-model="drawer"
        temporary
      >
        <v-list nav>
          <v-list-item
            v-for="item in items"
            :key="item.title"
            link
            :to="item.to"
          ><v-icon start>{{ item.icon }}</v-icon>{{ item.title }}</v-list-item>

          <v-divider />

          <v-list-subheader>Contribute</v-list-subheader>
          <v-list-item
            v-for="item in contributeItems"
            :key="item.title"
            link
            :to="item.to"
          >
            <v-icon v-if="item.icon" start>{{ item.icon }}</v-icon>
              <span style="vertical-align: middle;">{{ item.title }}</span>
          </v-list-item>
          
          <v-divider />
          
          <v-list-subheader>Get Involved</v-list-subheader>
          <v-list-item
            v-for="item in metaItems"
            :key="item.title"
            link
            :to="item.to"
            :href="item.href"
            :target="{ '_blank': item.href }"
          >
            <v-icon v-if="item.icon" start>{{ item.icon }}</v-icon>
              <v-img v-else-if="item.customIcon" class="mr-2 custom-icon" contain width="24" height="24" :src="isDark ? item.customIconDark : item.customIcon" style="vertical-align: middle;" />
              <span style="vertical-align: middle;">{{ item.title }}</span>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </template>

    <v-main>
      <RouterView />
    </v-main>

    <v-snackbar
      close-delay="2000"
      v-model="snackbar.show"
      color="grey-darken-3"
    >
      <v-icon start>mdi-theme-light-dark</v-icon>
      {{ snackbar.text }}
      <template v-slot:actions>
        <v-btn
          color="blue"
          variant="text"
          @click="snackbar.show = false"
        >
          <v-icon>mdi-close</v-icon>
        </v-btn>
      </template>
    </v-snackbar>

    <DiscordWarningDialog
      v-model="showDialog"
      :discordUrl="discordUrl"
      @proceed="handleDiscordProceed"
    />
  </v-app>
</template>

<style lang="css" scoped>
.custom-icon {
  display: inline-block;
  margin-right: 5px;
}
</style>
