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
        <ion-col size = 100px>Titel</ion-col>
        <ion-col size = 100px>Kino Name</ion-col>
        <ion-col size = 100px>Kino Adresse</ion-col>
        <ion-col size = 100px>Vorstellungsdatum</ion-col>
        <ion-col size = 100px>Vorstellungsbeginn</ion-col>
        <ion-col size = 100px>Telefonnummer</ion-col>
      <div v-for="item in listItems" :key="item">
        <ion-row size = 100px>{{ item.movie.movieName }}
          {{ item.cinema.cinemaName }}
          {{ item.showtimeId }}
          {{ item.cinema.cinemaAddress }}
          {{ item.showtimesDate }}
          {{ item.showtimesTime}}</ion-row>
         {{ item.cinema.cinemaPhone }}
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang ="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonInput, IonButton, IonRow, IonGrid, IonItem, IonCol, IonCard } from '@ionic/vue';
import axios from 'axios';
  import { ref } from 'vue';

  const listItems = ref();
  const search = ref();

  function getData() {
    const res = axios.get('http://localhost:8080/api/movies/'+search.value).then(response => {
      console.log(response);
      listItems.value = response.data;
    })
  }
</script>
