import {useState} from 'react';


const StateHookDemo = () => {
    const [name, setName] = useState("useState");

    return (
        <h1>{name} Hook Demo</h1>
    );
}

export default StateHookDemo;