function clearAnimations() {
  document.getElementById('rain').innerHTML='';
  document.getElementById('mist').innerHTML='';
  document.getElementById('clouds').innerHTML='';
}

function addRain() {
  const rainDiv=document.getElementById('rain');
  for(let i=0;i<100;i++){
    const drop=document.createElement('div');
    drop.style.left=Math.random()*100+'%';
    drop.style.animationDuration=0.5+Math.random()*0.5+'s';
    drop.style.height=10+Math.random()*15+'px';
    rainDiv.appendChild(drop);
  }
}
function addMist() {
  const mistDiv=document.getElementById('mist');
  for(let i=0;i<5;i++){
    const m=document.createElement('div');
    m.style.top=i*20+'%';
    mistDiv.appendChild(m);
  }
}
function addClouds() {
  const cloudsDiv=document.getElementById('clouds');
  for(let i=0;i<3;i++){
    const c=document.createElement('div');
    c.style.top=i*40+'px';
    c.style.animationDuration=20+Math.random()*10+'s';
    cloudsDiv.appendChild(c);
  }
}

function setWeatherIcon(condition){
  const icon=document.getElementById('weatherIcon');
  condition=condition.toLowerCase();
  if(condition.includes('rain')){
    icon.src='https://img.icons8.com/color/96/000000/rain.png';
    addRain();
  } else if(condition.includes('mist')||condition.includes('fog')){
    icon.src='https://img.icons8.com/color/96/000000/fog-day.png';
    addMist();
  } else if(condition.includes('cloud')){
    icon.src='https://img.icons8.com/color/96/000000/cloud.png';
    addClouds();
  } else if(condition.includes('sun')||condition.includes('clear')){
    icon.src='https://img.icons8.com/color/96/000000/sun--v1.png';
  } else if(condition.includes('moon')||condition.includes('night')){
    icon.src='https://img.icons8.com/color/96/000000/full-moon.png';
  } else { icon.src=''; }
}

// Birds flying
function addBirds(){
  const birdsLayer=document.getElementById('birds');
  for(let i=0;i<5;i++){
    const bird=document.createElement('div');
    bird.innerHTML='🕊️';
    bird.style.position='absolute';
    bird.style.fontSize=(15+Math.random()*20)+'px';
    bird.style.left=-10+'%';
    bird.style.top=(10+Math.random()*50)+'%';
    bird.style.animation=`flyBirds ${30+Math.random()*20}s linear infinite`;
    birdsLayer.appendChild(bird);
  }
}
addBirds();

async function getWeather() {
  const city=document.getElementById('cityInput').value;
  const days=document.getElementById('daysInput').value;
  try{
    const response=await fetch(`http://localhost:8081/weather/forecast?city=${city}&days=${days}`);
    const data=await response.json();
    const current=data.weatherResponse;

    document.getElementById('currentWeather').querySelector('h2').innerText=`${current.city}, ${current.region}, ${current.country}`;
    document.getElementById('currentWeather').querySelector('h3').innerText=`${current.condition}`;
    document.getElementById('currentWeather').querySelector('.temp').innerText=`${current.temperature}°C`;

    clearAnimations();
    setWeatherIcon(current.condition);

    const forecastDiv=document.getElementById('forecast');
    forecastDiv.innerHTML="";
    data.dayTemp.forEach(day=>{
      forecastDiv.innerHTML+=`
        <div class="day-card">
          <h4>${day.date}</h4>
          <p>Min: ${day.minTemp}°C</p>
          <p>Avg: ${day.avgTemp}°C</p>
          <p>Max: ${day.maxTemp}°C</p>
        </div>
      `;
    });
  }catch(err){ alert("Error fetching weather data"); }
}

getWeather();
