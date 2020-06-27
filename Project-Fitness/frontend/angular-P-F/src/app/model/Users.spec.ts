import { User } from './user';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
describe('User', ()=> {
    it ('should create an instance of User', ()=>{
        expect(new User('','',null,null,null)).toBeTruthy;
    })
})
it('should accept values',() => {
       const m = new User(
       this.username= "kgsmith",
        this.pass="adfa",
         this.ages=22,
        this.heights=55,
         this.weights=180,)
    expect(m.this.username).toEqual("kgsmith");
    expect(m.this.pass).toEqual("adfa");
    expect(m.this.ages).toEqual(22);
    expect(m.this.heights).toEqual(55);
    expect(m.this.weights).toEqual(180);
    
})