<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>MovieSearch</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" padding>
      <ion-grid>
        <ion-row justify-content-center>
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
            <div padding>
              <ion-item>
                <ion-input type="text" placeholder="Movie Name" v-model="search"></ion-input>
              </ion-item>
            </div>
            <div padding>
              <ion-button size="large" @click="getData" expand="block">Search</ion-button>
            </div>
          </ion-col>
        </ion-row>
      </ion-grid>
      <div v-for="item in listItems" :key="item.showtime_ID">
        {{item.showtime_ID}}
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang ="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonInput, IonButton, IonRow, IonGrid } from '@ionic/vue';
  import { ref } from 'vue';

  const listItems = ref();
  const search = ref();

  async function getData() {
<<<<<<< HEAD
    const res = await fetch("http://localhost:8080/api/movies/"+search.value);
=======
    const res = await fetch("http://localhost:8080/api/movies/?");
>>>>>>> ef7a009eff7bb6fb5cb1fd4f603955cbb8568ccf
    const finalRes = await res.json();
    listItems.value = finalRes;
  }
</script>
