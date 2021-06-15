
let table = document.querySelector('#table');

for (let i = 0; i < 63; i++) {
    let tail = document.getElementById(i.toString());
    tail.innerHTML="";
    // let r = document.querySelector(i.toString());
    // r.innerHTML="";

    for (let i = 0; i < 3; i++) {
        let td = document.createElement('td');
        td.innerHTML = 'x';
        tr.appendChild(td);
    }

    table.appendChild(tr);
}