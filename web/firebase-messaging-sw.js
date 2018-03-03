/*importScripts('https://www.gstatic.com/firebasejs/3.9.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/3.9.0/firebase-messaging.js');

var config = {
    apiKey: "AIzaSyD21GOdRp__k6rRAURks9GSwmbmXi3sSbk",
    authDomain: "twitter-f2804.firebaseapp.com",
    databaseURL: "https://twitter-f2804.firebaseio.com",
    projectId: "twitter-f2804",
    storageBucket: "twitter-f2804.appspot.com",
    messagingSenderId: "854198312900"
  };
  firebase.initializeApp(config);
  
  const messaging = firebase.messaging();
  messaging.setBackgroundMessageHandler(function(payload){
      const title = 'Hello World';
      const options = {
          body: payload.data.status
      };
      return self.registration.showNotification(title,options);
  });*/