export class PastWorkouts{

    
    private username:string;
    private exercise:string;
    private reps:number;

    constructor(username:string, exercise:string, reps:number){
        this.username = username;
        this.exercise = exercise;
        this.reps = reps;
    }


    public getUsername():string{
        return this.username;
    }

    public setUsername(username:string){
        this.username = username;
    }

    public getExercise():string{
        return this.exercise;
    }

    public setExercise(exercise:string){
        this.exercise = exercise;
    }

    public getReps():number{
        return this.reps;
    }

    public setReps(reps:number){
        this.reps = reps;
    }
}
