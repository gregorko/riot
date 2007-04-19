<form id="${form.id}" method="post" enctype="multipart/form-data">
<div id="elements">
	<#if form.hint?exists>
		<div class="form-hint">${form.hint}</div>
	</#if>
	<#if form.hasErrors()>
		<div class="form-error">${form.errors.generalFormError}</div>
	</#if>
	<#list elements.elements as element>
		<div class="${(element.compositeElement?default(false))?string('composite','single')}<#if element.styleClass?exists> ${element.styleClass}-element</#if>">
			<#if element.label?exists>
				<#if element.compositeElement?default(false)>
					<div class="title">
						<label for="${element.id}">
							<#if element.label?has_content>
								${element.label}
							<#else>
								<span class="no-label"></span>
							</#if>
							<#if element.hint?exists>
								<span class="hint-trigger" onclick="toggleHint('${element.id}-hint')"></span>
							</#if>
						</label>
					</div>
				<#else>
					<label for="${element.id}">
						${element.label}
						<#if element.hint?exists>
							<span class="hint-trigger" onclick="toggleHint('${element.id}-hint')"></span>
						</#if>
					</label>
				</#if>
			</#if>
			<div class="element">
				<#if element.hint?exists>
					<div id="${element.id}-hint" class="hint">${element.hint}</div>
				</#if>
				${element.render()}
				${form.errors.renderErrors(element)}
			</div>
		</div>
	</#list>
</div>

<#if buttons?exists>
	<div class="buttons">
		<#list buttons.elements as button>
			${button.render()}
		</#list>
	</div>
</#if>
</form>