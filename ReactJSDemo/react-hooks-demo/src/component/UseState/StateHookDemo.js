import React, {useState} from "react";

const StateHookDemo = () => {
    
    // declaring the state and setState for useState hook and initializing the state using useState()
    const [count,setCount] = useState(0)

    const [inputValue,setInputValue] = useState('IGD')

    const inputToggle = (event) => {

        setInputValue(event.target.value);
    }
    

    return (
        <div>
        <p>React Hooks : useState Demo !!! </p>
        <p>Click on this Button to increment: </p>
        <button onClick = {() => {
        setCount(count+1); // updating the state {count} using setCount function of useState hook
    }
    
    
    }
    > {count} </button>
    <br/>
    <p> useEffect to capture the input value entered ...</p>
    <br/>
    <input placeholder='Enter something here to get it reflected..' onChange={ inputToggle }/> {inputValue}
    </div>
    );

};

export default StateHookDemo;