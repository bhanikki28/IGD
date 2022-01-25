import React, {useState,useRef} from "react";

const ReferenceHookDemo = () => {
    const firstName = useRef();
    const lastName = useRef();
    const emailId = useRef();

    const submit = (e) => {
        e.preventDefault();
        const firstNameValue = firstName.current.value;
        const lastNameValue = lastName.current.value;
        const emailIdValue = emailId.current.value;
        console.log("User has entered ", firstNameValue,lastNameValue,emailIdValue);
        

    }

    return (
        <form onSubmit={submit}>
            <input type="text" ref={firstName} placeholder="firstName"/>
            <input type="text" ref={lastName} placeholder="lastName"/>
            <input type="text" ref={emailId} placeholder="emailId"/>
            <button> Add Employee</button>
            

        </form>
    ); 

};

export default ReferenceHookDemo;