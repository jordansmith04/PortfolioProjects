import React, { Component } from 'react'
import User from '../../../backend/models/user.model';

export default class EditProfile extends Component{
    constructor(props){
        super(props);
    
        const user_info =  localStorage.getItem('user');

        this.handleChange = this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)

        this.state = {
            user_id: user_info.user_id,
            password: user_info.password,
            email: user_info.email,
            first_name: user_info.first_name,
            last_name: user_info.last_name
    }
    }

    handleChange = e => {
        this.setState({ [name]: e.target.value})
    }

    onSubmit = data => {

        const user2 = new User(this.state.email, this.state.password, this.state.first_name, this.state.last_name)
        console.log(data);
        axios.post('http://localhost:5000/update/' + this.state.user_id, user2)
          .then(res => console.log(res.data));
    }

    render(){
        return(
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="First name" name="First name" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                <input type="text" placeholder="Last name" name="Last name" ref={register({required: true, maxLength: 100})}  onChange={this.handleChange(e)}/>
                <input type="text" placeholder="Email" name="Email" ref={register({required: true, pattern: /^\S+@\S+$/i})}  onChange={this.handleChange(e)}/>
                <input type="text" placeholder="Password" name="Password" ref={register({required: true, min: 6, pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm/i})}  onChange={this.handleChange(e)}/>

                <input type="submit" />
                
            </form>

        )
    }

}