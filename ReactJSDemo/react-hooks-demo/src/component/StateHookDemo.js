import React, {useState} from "react";

const StateHookDemo = () => {
    
    // declaring the state and setState for useState hook and initializing the state using useState()
    let [count,setCount] = useState(0)

    return (
        <>
        <p>React Hooks : useState Demo !!! </p>
        <p>Click on this Button to increment: </p>
        <button onClick = {() => {
        setCount(count+1);
    }
    
    
    }
    > {count} </button>
    </>
    );

};

export default StateHookDemo;