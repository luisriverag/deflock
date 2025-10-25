import { ref, readonly } from 'vue';

interface FeatureFlags {
  iosApp: {
    enabled: boolean;
    appUrl: string;
  };
}

const flags = ref<FeatureFlags | null>(null);
const isLoading = ref(false);
const error = ref<string | null>(null);

let fetchPromise: Promise<void> | null = null;

async function fetchFeatureFlags(): Promise<void> {
  if (flags.value !== null) {
    // Already loaded
    return;
  }

  if (fetchPromise) {
    // Already fetching, wait for the existing promise
    return fetchPromise;
  }

  fetchPromise = (async () => {
    try {
      isLoading.value = true;
      error.value = null;

      const response = await fetch('https://cdn.deflock.me/config/flags.json');
      
      if (!response.ok) {
        throw new Error(`Failed to fetch feature flags: ${response.status}`);
      }

      const data = await response.json();
      flags.value = data;
    } catch (err) {
      error.value = err instanceof Error ? err.message : 'Unknown error';
      console.warn('Failed to load feature flags, using defaults:', error.value);
      
      // Fallback to default values
      flags.value = {
        iosApp: {
          enabled: false,
          appUrl: ''
        }
      };
    } finally {
      isLoading.value = false;
    }
  })();

  return fetchPromise;
}

export function useFeatureFlags() {
  // Auto-fetch on first use
  if (!fetchPromise) {
    fetchFeatureFlags();
  }

  return {
    flags: readonly(flags),
    isLoading: readonly(isLoading),
    error: readonly(error),
    refresh: fetchFeatureFlags
  };
}