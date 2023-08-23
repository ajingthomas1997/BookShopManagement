<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- ---------------------------------------------------------------------------->
<script type="module">
    import * as LR from "https://cdn.jsdelivr.net/npm/@uploadcare/blocks@0.25.0/web/file-uploader-regular.min.js";

    LR.registerBlocks(LR);
</script>
<style type="text/css">
.my-config {
	--darkmode: 1;
	--h-accent: 0;
	--s-accent: 0%;
	--l-accent: 9%;
}

<!--
---------------------------------------------------------------------------->.st0
	{
	fill: none;
	stroke: #000000; /* Change the stroke color to black */
	stroke-width: 2;
	stroke-linecap: round;
	stroke-linejoin: round;
	stroke-miterlimit: 10;
}

/* Change background and button color to black */
#container {
	background-color: #000000;
	width: 100%;
}

body {
	background: #0CE9AF;
	display: flex;
	flex-direction: column;
	font-family: Lato;
	height: 100%;
	margin: auto;
	text-shadow: 0 0px 2px rgba(245, 245, 245, .25);
}

.box-input {
	text-align: center;
}

.box-input svg {
	width: 5rem;
	height: 5rem;
	vertical-align: middle;
	fill: currentColor;
}

form {
	color: #fff;
}

input[type="button" i], input[type="file" i]::-webkit-file-upload-button
	{
	display: none !important;
}

.box.has-advanced-upload {
	transition: all .15s ease-in-out, background-color .15s linear;
}

.box {
	font-size: 1.25rem;
	background-color: rgba(0, 142, 198, 1);
	border: 4px solid #fff;
	box-shadow: inset 0 2px 4px rgba(0, 0, 0, .75);
	padding: 5rem 8rem;
	width: 100%;
}

.js .box-file {
	width: .1px;
	height: .1px;
	opacity: 0;
	overflow: hidden;
	position: absolute;
	z-index: -1;
}

.box-input label {
	margin: auto;
	text-overflow: ellipsis;
	white-space: nowrap;
	color: #fff;
	cursor: pointer;
	text-align: center;
	display: block;
	overflow: hidden;
}

.js .box-file+label * {
	pointer-events: none;
}

.js .box-file:focus+label {
	outline: 1px dotted #000;
	outline: -webkit-focus-ring-color auto 5px;
}

button {
	border: none;
	box-shadow: 0 2px 4px rgba(0, 0, 0, .25);
	display: flex;
	font-size: 1.25rem;
	font-weight: 700;
	margin: auto;
	margin-top: 2.5rem;
	overflow: auto;
	padding: 1rem 1.5rem;
	background-color: #000000;
	color: #FFFFFF;
}

button:hover {
	box-shadow: 0 4px 12px rgba(0, 0, 0, .5);
}

button:active {
	box-shadow: none;
}

.box-uploading {
	font-style: italic;
}

.box-success {
	transition: appear-from-inside .25s ease-in-out;
}

.box__success {
	animation: appear-from-inside .25s ease-in-out;
}

@
keyframes appear-from-inside {from { transform:translateY(-50%)scale(0);
	
}

75






%
{
transform






:






translateY




(






-50




%
)






scale




(






1




.1






)




;
}
to {
	transform: translateY(-50%) scale(1);
}

}
.box-restart {
	font-weight: 700;
}

input, textarea, select {
	border-radius: 0;
	border: none;
}

input {
	line-height: normal;
}

.box-dragndrop, .box-icon, .box-uploading, .box-success, .box-error {
	display: none;
}

.box.has-advanced-upload .box-dragndrop {
	display: inline;
}

strong {
	color: #fff;
}
</style>
<script type="text/javascript">
	'use strict';

	;
	(function(document, window, index) {
		// feature detection for drag&drop upload
		var isAdvancedUpload = function() {
			var div = document.createElement('div');
			return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div))
					&& 'FormData' in window && 'FileReader' in window;
		}();

		// applying the effect for every form
		var forms = document.querySelectorAll('.box');
		Array.prototype.forEach
				.call(
						forms,
						function(form) {
							var input = form
									.querySelector('input[type="file"]'), label = form
									.querySelector('label'), errorMsg = form
									.querySelector('.box-error span'), restart = form
									.querySelectorAll('.box-restart'), droppedFiles = false, showFiles = function(
									files) {
								label.textContent = files.length > 1 ? (input
										.getAttribute('data-multiple-caption') || '')
										.replace('{count}', files.length)
										: files[0].name;
							}, triggerFormSubmit = function() {
								var event = document.createEvent('HTMLEvents');
								event.initEvent('submit', true, false);
								form.dispatchEvent(event);
							};

							// letting the server side to know we are going to make an Ajax request
							var ajaxFlag = document.createElement('input');
							ajaxFlag.setAttribute('type', 'hidden');
							ajaxFlag.setAttribute('name', 'ajax');
							ajaxFlag.setAttribute('value', 1);
							form.appendChild(ajaxFlag);

							// automatically submit the form on file select
							input.addEventListener('change', function(e) {
								showFiles(e.target.files);

							});

							// drag&drop files if the feature is available
							if (isAdvancedUpload) {
								form.classList.add('has-advanced-upload'); // letting the CSS part to know drag&drop is supported by the browser

								[ 'drag', 'dragstart', 'dragend', 'dragover',
										'dragenter', 'dragleave', 'drop' ]
										.forEach(function(event) {
											form.addEventListener(event,
													function(e) {
														// preventing the unwanted behaviours
														e.preventDefault();
														e.stopPropagation();
													});
										});
								[ 'dragover', 'dragenter' ].forEach(function(
										event) {
									form.addEventListener(event, function() {
										form.classList.add('is-dragover');
									});
								});
								[ 'dragleave', 'dragend', 'drop' ]
										.forEach(function(event) {
											form
													.addEventListener(
															event,
															function() {
																form.classList
																		.remove('is-dragover');
															});
										});
								form.addEventListener('drop', function(e) {
									droppedFiles = e.dataTransfer.files; // the files that were dropped
									showFiles(droppedFiles);

								});
							}

							// if the form was submitted
							form
									.addEventListener(
											'submit',
											function(e) {
												// preventing the duplicate submissions if the current one is in progress
												if (form.classList
														.contains('is-uploading'))
													return false;

												form.classList
														.add('is-uploading');
												form.classList
														.remove('is-error');

												if (isAdvancedUpload) // ajax file upload for modern browsers
												{
													e.preventDefault();

													// gathering the form data
													var ajaxData = new FormData(
															form);
													if (droppedFiles) {
														Array.prototype.forEach
																.call(
																		droppedFiles,
																		function(
																				file) {
																			ajaxData
																					.append(
																							input
																									.getAttribute('name'),
																							file);
																		});
													}

													// ajax request
													var ajax = new XMLHttpRequest();
													ajax
															.open(
																	form
																			.getAttribute('method'),
																	form
																			.getAttribute('action'),
																	true);

													ajax.onload = function() {
														form.classList
																.remove('is-uploading');
														if (ajax.status >= 200
																&& ajax.status < 400) {
															var data = JSON
																	.parse(ajax.responseText);
															form.classList
																	.add(data.success == true ? 'is-success'
																			: 'is-error');
															if (!data.success)
																errorMsg.textContent = data.error;
														} else
															alert('Error. Please, contact the webmaster!');
													};

													ajax.onerror = function() {
														form.classList
																.remove('is-uploading');
														alert('Error. Please, try again!');
													};

													ajax.send(ajaxData);
												} else // fallback Ajax solution upload for older browsers
												{
													var iframeName = 'uploadiframe'
															+ new Date()
																	.getTime(), iframe = document
															.createElement('iframe');

													$iframe = $('<iframe name="' + iframeName + '" style="display: none;"></iframe>');

													iframe.setAttribute('name',
															iframeName);
													iframe.style.display = 'none';

													document.body
															.appendChild(iframe);
													form.setAttribute('target',
															iframeName);

													iframe
															.addEventListener(
																	'load',
																	function() {
																		var data = JSON
																				.parse(iframe.contentDocument.body.innerHTML);
																		form.classList
																				.remove('is-uploading')
																		form.classList
																				.add(data.success == true ? 'is-success'
																						: 'is-error')
																		form
																				.removeAttribute('target');
																		if (!data.success)
																			errorMsg.textContent = data.error;
																		iframe.parentNode
																				.removeChild(iframe);
																	});
												}
											});

							// restart the form if has a state of error/success
							Array.prototype.forEach.call(restart, function(
									entry) {
								entry.addEventListener('click', function(e) {
									e.preventDefault();
									form.classList.remove('is-error',
											'is-success');
									input.click();
								});
							});

							// Firefox focus bug fix for file input
							input.addEventListener('focus', function() {
								input.classList.add('has-focus');
							});
							input.addEventListener('blur', function() {
								input.classList.remove('has-focus');
							});

						});
	}(document, window, 0));
</script>
</head>
<body>

	<div id="container">
		<form action="imageUpload" method="post" enctype="multipart/form-data"
			novalidate="" class="box has-advanced-upload">
			<div class="box-input">
				<svg x="0px" y="0px" viewBox="0 0 64 62"
					style="enable-background: new 0 0 64 62;" xml:space="preserve">

<g id="spa-launch">
	<path class="st0"
						d="M33,27.1h-8c0,0-2-6-2-12c0-8,6-14,6-14s6,6,6,14C35,21.1,33,27.1,33,27.1z" />
	<line class="st0" x1="29" y1="17.1" x2="29" y2="27.1" />
	<polyline class="st0" points="25,27.1 17,27.1 17,23.1 23.1,17.1 	" />
	<polyline class="st0" points="33,27.1 41,27.1 41,23.1 34.9,17.1 	" />
	<path class="st0"
						d="M18,41.2c0.5-5.7,5.2-10.1,11-10.1c5.1,0,9.3,3.4,10.6,8.1" />
	<path class="st0"
						d="M48,41.1c-0.2-3.4-3.1-6-6.5-6c-1.2,0-2.4,0.3-3.3,0.9" />
	<path class="st0" d="M42.3,47.1c0,0-1-4-6-4" />
	<path class="st0" d="M26.3,43.1c-3-1-4,2-4,2s-3-2-5,0s-1,4-1,4" />
	<path class="st0"
						d="M9,46.1c-0.8-0.6-1.9-1-3-1c-2.8,0-5,2.2-5,5s2.2,5,5,5h46c2.8,0,5-2.2,5-5c0-5-4-9-9-9
		c-0.9,0-1.8,0.1-2.6,0.4" />
	<path class="st0"
						d="M18.8,37.9c-1.1-0.5-2.4-0.8-3.8-0.8c-4.6,0-8.5,3.5-8.9,8" />
</g>
</svg>
				<input type="file" name="files[]" id="file" class="box-file"
					data-multiple-caption="{count} files selected" multiple="multiple">
				<label for="file"><strong>Choose a file</strong><span
					class="box-dragndrop"> or drag it here</span>.</label>
				<button type="submit" class="button">Upload</button>
			</div>

			<div class="box-uploading">Uploading…</div>
			<div class="box-success">
				Done! <a
					href="https://css-tricks.com/examples/DragAndDropFileUploading//?submit-on-demand"
					class="box-restart" role="button" data-unsp-sanitized="clean">Upload
					more?</a>
			</div>
			<div class="box-error">
				Error! <span></span>. <a
					href="https://css-tricks.com/examples/DragAndDropFileUploading//?submit-on-demand"
					class="box-restart" role="button" data-unsp-sanitized="clean">Try
					again!</a>
			</div>
			<input type="hidden" name="ajax" value="1">
		</form>

	</div>

	<lr-config ctx-name="my-uploader" pubkey="e466b317fa8f8177fa97"
		max-local-file-size-bytes="10000000" multiple-max="100"
		img-only="true" source-list="local, camera"></lr-config>

</body>
</html>