<template>
  <v-sheet width="220">
    <!--  TODO: if a field is unknown, prompt user to edit it -->
    <v-img cover width="100%" height="120px" src="/alprs/flock-3.jpg" />
    <v-list density="compact" class="my-2">
      <v-list-item>
        <template v-slot:prepend>
          <v-icon icon="mdi-police-badge"></v-icon>
        </template>

        <v-list-item-subtitle style="font-size: 1em">
          Operated by
        </v-list-item-subtitle>
        
        <b>
          <span style="font-size: 1.25em">
            {{ abbreviatedOperator }}
          </span>
        </b>

        <template v-slot:append>
          <v-btn icon size="small" variant="text" :href="transparencyLink" target="_blank" color="primary">
            <v-icon icon="mdi-open-in-new"></v-icon>
          </v-btn>
        </template>
      </v-list-item>

      <v-divider class="my-2" />

      <v-list-item>
        <template v-slot:prepend>
          <v-icon icon="mdi-factory"></v-icon>
        </template>

        <v-list-item-subtitle style="font-size: 1em">
          Made by
        </v-list-item-subtitle>
        
        <b>
          <span style="font-size: 1.25em">
            {{ manufacturer }}
          </span>
        </b>
      </v-list-item>
    </v-list>

    <div class="text-center">
      <v-btn target="_blank" size="x-small" :href="osmNodeLink(props.alpr.id)" variant="text" color="grey"><v-icon start>mdi-open-in-new</v-icon>View on OSM</v-btn>
    </div>
  </v-sheet>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import type { PropType } from 'vue';
import type { ALPR } from '@/types';
import { VIcon, VList, VSheet, VListItem, VBtn, VImg, VListItemSubtitle, VDivider } from 'vuetify/components';

const props = defineProps({
  alpr: {
    type: Object as PropType<ALPR>,
    required: true
  }
});

const manufacturer = computed(() => (
  props.alpr.tags.manufacturer || props.alpr.tags.brand || 'Unknown'
));

const transparencyLink = computed(() => {
  // XXX: eventually get this from /api/operator-info?wikidata=Q1234
  return `https://transparency.flocksafety.com/boulder-co-pd`;
});

const abbreviatedOperator = computed(() => {
  if (props.alpr.tags.operator === undefined) {
    return 'Unknown';
  }

  const replacements: Record<string, string> = {
    "Police Department": "PD",
    "Sheriff's Office": "SO",
    "Sheriffs Office": "SO",
    // TODO: maybe include HOAs
  };

  const operator = props.alpr.tags.operator;
  for (const [full, abbr] of Object.entries(replacements)) {
    if (operator.includes(full)) {
      return operator.replace(full, abbr);
    }
  }
  return operator;
});

function osmNodeLink(id: string): string {
  return `https://www.openstreetmap.org/node/${id}`;
}
</script>
