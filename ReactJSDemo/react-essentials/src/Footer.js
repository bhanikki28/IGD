import {useState} from 'react';
const Footer = () => {
    const [ year, setYear ] = useState(new Date().getFullYear())
    return(
      <footer>
        <p> Nikki - {year} Copyrights Reserved!</p>
      </footer>
    );
  }
export default Footer;