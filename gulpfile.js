// Include Gulp
var gulp = require('gulp');

// Include plugins
var plugins = require("gulp-load-plugins")({
    pattern: ['gulp-*', 'gulp.*', 'main-bower-files'],
    replaceString: /\bgulp[\-.]/
});
var rename = require("gulp-rename");
var cleanCSS = require("gulp-clean-css");
var uglify = require("gulp-uglify");

var config = {
    'docs': 'docs/',
    'dest': 'src/main/resources/public/',
    'source': 'bower_components'
};

gulp.task('fonts', function() {
    gulp.src(['bower_components/materialize/dist/fonts/**'])
        .pipe(gulp.dest(config.docs + 'fonts'))
        .pipe(gulp.dest(config.dest + 'fonts'));
});

gulp.task('js', function() {
    gulp.src(plugins.mainBowerFiles())
        .pipe(plugins.filter('*.js'))
        .pipe(gulp.dest(config.docs + 'js'))
        .pipe(gulp.dest(config.dest + 'js'))
        .pipe(uglify())
        .pipe(rename({
            suffix: ".min"
        }))
        .pipe(gulp.dest(config.dest + 'js'));
});

gulp.task('css', function() {
    gulp.src(plugins.mainBowerFiles())
        .pipe(plugins.filter('*.css'))
        .pipe(gulp.dest(config.docs + 'css'))
        .pipe(gulp.dest(config.dest + 'css'))
        .pipe(cleanCSS())
        .pipe(rename({
            suffix: ".min"
        }))
        .pipe(gulp.dest(config.dest + 'css'));
});

gulp.task('img', function() {
});

gulp.task('additional_files', function() {
    gulp.src(config.docs + '*.html')
        .pipe(gulp.dest(config.dest));

    gulp.src(config.docs + 'css/*.css')
        .pipe(gulp.dest(config.dest + 'css'));

    gulp.src(config.docs + 'js/*.js')
        .pipe(gulp.dest(config.dest + 'js'));
});

gulp.task('default', ['fonts', 'js', 'css', 'img', 'additional_files']);


