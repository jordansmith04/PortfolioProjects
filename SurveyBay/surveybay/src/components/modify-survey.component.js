import React, { Component } from 'react'
import Survey from '../../../backend/models/survey.model';
import axios from 'axios';
import User from '../../../backend/models/user.model'

export default class ModifySurvey extends Component{
    constructor(props){
        super(props);
    

        this.handleChange = this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)

        this.state = {
            survey: Survey,
            keepClosed: true
    }
    }

    componentDidMount(){
        axios.get('http://localhost:5000/survey/')
        .then(response => {
            this.setState({
                survey: response.data
            })
        })
        .catch((err) => {
            console.log(err)
        })
    }

    handleChange(e) {
        const { name, value } = e.target;
        this.setState({ [name]: value });
    }
    onSubmit = data => {

        const user2 = new User(this.state.email, this.state.password, this.state.first_name, this.state.last_name)
        console.log(data);
        axios.post('http://localhost:5000/update/' + this.state.user_id, user2)
          .then(res => console.log(res.data));
    }

    render(){
        return(

            keepClosed ?
            <div>
            <label for="keep-open">Would you like to keep this survey open?</label>
            <input name="keep-open" type="radio" value="Yes" ref={register({ required: true })}/>
            <input name="keep-open" type="radio" value=" No" ref={register({ required: true })}/>
            </div>
            :
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder={this.state.survey.title} name="Title" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                <input type="text" placeholder={this.state.survey.Description} name="Description" ref={register({required: true, maxLength: 100})}  onChange={this.handleChange(e)}/>
                {
                    this.state.survey.questions.map((question) =>{
                        return(
                            <div>
                                Question: {question}
                                Answer #1: {question.answer[0]}
                                <input type="text" placeholder={question.answer[0]} name="q1" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                                Answer #2: {question.answer[1]}
                                <input type="text" placeholder={question.answer[1]} name="q2" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                                Answer #3: {question.answer[2]}
                                <input type="text" placeholder={question.answer[2]} name="q3" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                                Answer #4: {question.answer[3]}
                                <input type="text" placeholder={question.answer[3]} name="q4" ref={register({required: true, maxLength: 80})} onChange={this.handleChange(e)}/>
                            </div>
                        )
                    })

                    }



                    <input type="text" placeholder="Email" name="Email" ref={register({required: true, pattern: /^\S+@\S+$/i})}  onChange={this.handleChange(e)}/>
                <input type="text" placeholder="Password" name="Password" ref={register({required: true, min: 6, pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm/i})}  onChange={this.handleChange(e)}/>

                <input type="submit" />
                
            </form>

        )
    }

}