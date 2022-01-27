# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### React Components

        1. Every React Component has access to object called props , which can be passed to the component to access component properties
                eg : function Header(props){
                    return(
                        <header>
                            {props.name}
                        </header>
                    );
                }
            Alternatively, we can pass in the property directly like below and access it
                eg : function Header({name}){
                    return(
                        <header>
                            {name}
                        </header>
                    );
                }

            Note : if we need to pass numeric value as property, it needs to be wrapped inside {}, instead of "".
                    eg:  <Footer year={2022}/>

        2. Working on Lists
                itemlist.map((item) => console.log(item))
                need to have key values been set, to have unique value
                const dishObjects = dishes.map((dish,i) => ({ id: i, title: dish }));
                const dishes = [
                "Dosa",
                "Chapathi",
                "Idly",
                "Parotta",
                "Poori Masala"
                ];

                const dishObjects = dishes.map((dish,i) => ({ id: i, title: dish }));

        3. Working with Images
                Images can be imported into React Component using jsx 
                eg:
                    import restaurant from './restaurant.jpg';
                    <img src={restaurant} />

        4. Rendering more components
                use fragments to render more than one component <React.Fragment> or <>


### Conditional Rendering , Hooks ( useEffect, useState, useReducer) , Array Destructuring

        1. Render Components conditionally : { props.authorised ? ( <Component1 /> ): (<Component2 />)}

        2. /* Array Destructuring Demo */
            const [,,thirdItem] = ["one","two","three"];
            console.log(thirdItem); 
            Array Destructuring would be helpful, when it comes to deal with React Hooks like useState.
            
        3. Object Destructuring
            without using props, directly accessing the key value in the Component
            eg : function Header( {key}){
                return(
                    <header>
                        {key}  // since key is passed directly instead of props, its called Object Destructuring
                    </header>
                );
            }

        4. useState() hook
                - to manage state variables in a App
                - import {useState} from 'react'
                - it returns an array, firstElement is the value for the state variable and second element is function to setValue for that variable
                eg:
                        const [ year, setYear ] = useState(new Date().getFullYear())
                        <footer>
                            <p> Nikki - {year} Copyrights Reserved!</p>
                        </footer>

### React Tips

        1. Press Command + Option + J - to open up the console
        2. Install React Developer Tools extension to help in debugging
