var count = function countdown(counter) {
    return setInterval(function(){
        console.log(counter);
        counter--;
        if (counter === -1) {
            clearInterval(this);
        }
    }, 1000);
};

count(5);
