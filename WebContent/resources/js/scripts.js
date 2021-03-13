/**
 * 
 */

const deleteConfirmation = document.querySelector(".delete-confirmation");
const deleteButton = document.querySelector(".crud-button--delete");
const cancelButton = document.querySelector(".delete-confirmation__button--cancel");


// adds and removes the "change" class from the navbar when you click on the hamburger-menu
deleteButton.addEventListener("click", () => {
	deleteConfirmation.classList.toggle("open");
	
});

cancelButton.addEventListener("click", () => {
	deleteConfirmation.classList.toggle("open");
	
});
