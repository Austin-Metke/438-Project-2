USE company;
-- Drop tables in reverse order of dependencies
DROP TABLE IF EXISTS workout_plan_exercises;
DROP TABLE IF EXISTS workout_plans;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    g_id VARCHAR(255) UNIQUE,
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    profile_pic TEXT
) ENGINE=InnoDB;

-- Create profiles table
CREATE TABLE IF NOT EXISTS profiles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    age INT,
    weight INT,
    height INT,
    skill_level VARCHAR(50),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Create exercises table
CREATE TABLE IF NOT EXISTS exercises (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    muscle_group VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    equipment VARCHAR(50),
    difficulty VARCHAR(50),
    instructions TEXT
) ENGINE=InnoDB;

-- Create workout_plans table
CREATE TABLE IF NOT EXISTS workout_plans (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Create workout_plan_exercises table
CREATE TABLE IF NOT EXISTS workout_plan_exercises (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    workout_plan_id BIGINT NOT NULL,
    exercise_id BIGINT NOT NULL,
    day VARCHAR(50) NOT NULL,
    sets INT NOT NULL,
    reps INT NOT NULL,
    FOREIGN KEY(workout_plan_id) REFERENCES workout_plans(id) ON DELETE CASCADE,
    FOREIGN KEY(exercise_id) REFERENCES exercises(id)
) ENGINE=InnoDB;

-- Insert sample exercises
INSERT INTO exercises (name, description, muscle_group, type, equipment, difficulty, instructions) VALUES
('Push-Up', 'A bodyweight exercise that works the chest, shoulders, and triceps', 'Chest', 'Strength', 'Bodyweight', 'Beginner', 'Start in a plank position, lower your body until your chest nearly touches the floor, then push back up.'),
('Squat', 'A compound exercise that targets the legs and glutes', 'Legs', 'Strength', 'Bodyweight', 'Beginner', 'Stand with feet shoulder-width apart, bend knees and hips to lower your body, then return to standing.'),
('Plank', 'Core exercise to strengthen abdominals and lower back', 'Core', 'Strength', 'Bodyweight', 'Beginner', 'Hold your body in a straight line from head to heels, supporting weight on forearms and toes.'),
('Bicep Curl', 'Strengthens the biceps using dumbbells', 'Biceps', 'Strength', 'Dumbbell', 'Beginner', 'Hold dumbbells at your sides, curl them toward your shoulders, then lower slowly.'),
('Lunges', 'Strengthens legs and glutes', 'Legs', 'Strength', 'Bodyweight', 'Beginner', 'Step forward with one leg and lower your body until both knees are bent at 90 degrees, then return to start.'),
('Bench Press', 'Chest exercise using a barbell', 'Chest', 'Strength', 'Barbell', 'Intermediate', 'Lie on a bench, grip the barbell, lower it to your chest, and press back up.'),
('Deadlift', 'Full-body compound exercise targeting back and legs', 'Back', 'Strength', 'Barbell', 'Advanced', 'Stand with feet hip-width, lift the bar from the floor by extending hips and knees, keeping your back straight.'),
('Jumping Jacks', 'Full-body cardiovascular warm-up', 'Full Body', 'Cardio', 'Bodyweight', 'Beginner', 'Jump while spreading legs and raising arms overhead, then return to start.'),
('Mountain Climbers', 'Cardio exercise targeting core and legs', 'Core', 'Cardio', 'Bodyweight', 'Intermediate', 'Start in a plank, drive knees toward chest alternately as fast as possible.'),
('Pull-Up', 'Upper body exercise targeting back and arms', 'Back', 'Strength', 'Pull-Up Bar', 'Advanced', 'Hang from a bar, pull your body up until your chin is over the bar, then lower slowly.');
