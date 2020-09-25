import React from 'react';
import { useForm } from 'react-hook-form';

export default function Register() {
  const { register, handleSubmit, errors } = useForm();
  const onSubmit = data => {
      console.log(data);
      axios.post('http://localhost:5000/users/register', data)
        .then(res => console.log(res.data));
  }
  console.log(errors);
  
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input type="text" placeholder="First name" name="First name" ref={register({required: true, maxLength: 80})} />
      <input type="text" placeholder="Last name" name="Last name" ref={register({required: true, maxLength: 100})} />
      <input type="text" placeholder="Email" name="Email" ref={register({required: true, pattern: /^\S+@\S+$/i})} />
      <input type="text" placeholder="Password" name="Password" ref={register({required: true, min: 6, pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm/i})} />

      <input name="Will you be using this in a professional capacity?" type="radio" value="Yes" ref={register({ required: true })}/>
      <input name="Will you be using this in a professional capacity?" type="radio" value=" No" ref={register({ required: true })}/>

      <input type="submit" />
      <Link to="/login" className="btn btn-link">Cancel</Link>
    </form>
  );
}