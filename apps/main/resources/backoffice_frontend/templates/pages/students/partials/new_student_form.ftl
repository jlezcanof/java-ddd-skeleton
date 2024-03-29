<form class="w-full max-w-lg float-right" method="post" action="/students">
    <h2 class="block uppercase tracking-wide text-gray-700 text-3xl font-bold mb-2">Crear estudiante</h2>
    <div class="flex flex-wrap mb-6 -mx-3">
        <div class="w-full md:w-full px-3 mb-6 md:mb-0">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
                Identificador
            </label>
            <input class="<#if errors['id']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-first-name" type="text" name="id" placeholder="En formado UUID"
                   value="${(inputs['id'])!generated_uuid}">

            <#if errors['id']?? >
                <#list errors['id'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
    </div>
    <div class="flex flex-wrap -mx-3 mb-6">
        <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
                Nombre
            </label>
            <input class="<#if errors['name']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-first-name" type="text" name="name" placeholder="Roberto"
                   value="${(inputs['name'])!""}">

            <#if errors['name']?? >
                <#list errors['name'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
        <div class="w-full md:w-1/2 px-3">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-last-name">
                Apellido
            </label>
            <input class="<#if errors['surname']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-last-name" type="text" name="surname" placeholder="8 days"
                   value="${(inputs['surname'])!""}">
            <#if errors['surname']?? >
                <#list errors['surname'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>

        <div class="w-full md:w-1/2 px-3">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-last-name">
                        Email
            </label>
            <input class="<#if errors['email']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-last-name" type="text" name="email" placeholder="8 days"
                   value="${(inputs['email'])!""}">
            <#if errors['email']?? >
                <#list errors['email'] as errorMessage>
                      <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
    </div>
    <div class="flex flex-wrap mb-6">
        <button class="md:w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="submit">
            Crear estudiante!
        </button>
    </div>
</form>
