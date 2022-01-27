import logo from './logo.svg';
import './App.css';
import restaurant from './restaurant.jpg';


function Header({name}){
  return(
    <header>
      <h1> {name}'s Kitchen</h1>
    </header>
  );
}

function Main({items}){
  return(
    <section>
      <p>We serve the below delicious foods!</p>
      <img src={restaurant} height={200} alt="Restaurant Image"/>
       <ul style={{ textAlign: 'left'}}>{items.map((item) => <li key={item.id}>{item.title}</li>)}</ul>
    </section>
  );
}

function Footer({year}){
  return(
    <footer>
      <p> Nikki - {year} Copyrights Reserved!</p>
    </footer>
  );
}

let counter = 0;

const dishes = [
  "Dosa",
  "Chapathi",
  "Idly",
  "Parotta",
  "Poori Masala"
];

const dishObjects = dishes.map((dish,i) => ({ id: i, title: dish }));

function App() {
  return (
    <div className="App">
      <Header name="Nikki" />
      <Main items={dishObjects}/>
      <Footer year={new Date().getFullYear()}/>
    </div>
  );
}

export default App;
